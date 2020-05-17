import React, {useState, useEffect} from 'react';
import {
  SafeAreaView,
  View,
  StyleSheet,
  Text,
  Button,
  Dimensions,
} from 'react-native';
import CalorieCounter from './CalorieCounter';
import MacroContainer from './MacroContainer';
import Navigation from './Navigation';
import MealsContainer from './MealsContainer';
import Icon from 'react-native-vector-icons/MaterialCommunityIcons';
import {Actions} from 'react-native-router-flux';
import AsyncStorage from '@react-native-community/async-storage';
import Axios from 'axios';

const screenWidth = Math.round(Dimensions.get('window').width);

const HomePage = () => {
  const [accessToken, setAccessToken] = useState(null);
  const [profile, setProfile] = useState(new Object());
  const [date, setDate] = useState(new Date());
  const [expand, setExpand] = useState(true);

  useEffect(() => {
    _retrieveData();
  }, []);

  const _retrieveData = async () => {
    try {
      const value = await AsyncStorage.getItem('access_token');
      if (value !== null) {
        setAccessToken(value);
        Axios.get('http://10.0.2.2:8080/profile', {
          headers: {'X-Auth-Token': value},
        })
          .then(response => setProfile(response.data))
          .catch(error => Actions.replace('login'));
      } else {
        Actions.replace('login');
      }
    } catch (error) {
      alert('Unexpected error');
      Actions.replace('login');
    }
  };
  return (
    <SafeAreaView style={styles.body}>
      <View
        style={{
          backgroundColor: '#353535',
          borderBottomLeftRadius: 600,
          borderBottomRightRadius: 600,
          width: 950,
          alignSelf: 'center',
        }}>
        <Text style={styles.text}>CLASSIC DIETING</Text>

        <View
          style={{
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'center',
            width: screenWidth,
            alignSelf: 'center',
          }}>
          <View
            style={{
              flex: 1,
              display: 'flex',
              justifyContent: 'center',
            }}>
            <Text style={styles.sideTitle}>{'BODY \nSTATUS'}</Text>
            <Text style={styles.sideText}>{profile.bodyStatus}</Text>
          </View>

          <View style={{flex: 1, marginHorizontal: 10}}>
            <CalorieCounter />
          </View>

          <View
            style={{
              flex: 1,
              display: 'flex',
              justifyContent: 'center',
            }}>
            <Text style={styles.sideTitle}>{'TOTAL \nCALORIES'}</Text>
            <Text style={styles.sideText}>{parseInt(profile.calories)}</Text>
          </View>
        </View>

        <MacroContainer />

        <Navigation />
      </View>

      <MealsContainer />
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  body: {
    flex: 1,
    backgroundColor: '#1b1b1b',
  },
  text: {
    color: 'white',
    textAlign: 'center',
    fontSize: 20,
    marginTop: 20,
    fontWeight: 'bold',
  },
  arrowContainer: {
    display: 'flex',
    flexDirection: 'row',
    justifyContent: 'center',
  },
  sideText: {
    textAlign: 'center',
    color: 'white',
    marginVertical: 5,
  },
  sideTitle: {
    textAlign: 'center',
    color: 'rgb(0, 255, 150)',
    marginVertical: 5,
    fontSize: 16,
    fontWeight: 'bold',
  },
});

export default HomePage;
