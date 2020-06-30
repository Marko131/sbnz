import React, {useState, useEffect} from 'react';
import {SafeAreaView, View, StyleSheet, Text, Dimensions} from 'react-native';
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
  const [day, setDay] = useState({});
  const [view, setView] = useState(null);

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
        Axios.get('http://10.0.2.2:8080/day/meal', {
          headers: {'X-Auth-Token': value},
        })
          .then(response => {
            setDay(response.data);
            setView(
              <MealsContainer day={response.data} refresh={_retrieveData} />,
            );
          })
          .catch(error => alert(error));
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
      <View style={styles.topBackground}>
        <Text style={styles.text}>CLASSIC DIETING</Text>

        <View style={styles.container}>
          <View style={styles.bodyStatus}>
            <Text style={styles.sideTitle}>{'BODY \nSTATUS'}</Text>
            <Text style={styles.sideText}>{profile.bodyStatus}</Text>
          </View>

          <View style={{flex: 1, marginHorizontal: 10}}>
            <CalorieCounter profile={profile} day={day} />
          </View>

          <View style={styles.totalCalories}>
            <Text style={styles.sideTitle}>{'TOTAL \nCALORIES'}</Text>
            <Text style={styles.sideText}>{parseInt(profile.calories)}</Text>
          </View>
        </View>

        <MacroContainer day={day} />

        <Navigation
          refresh={_retrieveData}
          changeView={view => setView(view)}
          setDefaultView={() =>
            setView(<MealsContainer day={day} refresh={_retrieveData} />)
          }
        />
      </View>

      {view}
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {
    display: 'flex',
    flexDirection: 'row',
    justifyContent: 'center',
    width: screenWidth,
    alignSelf: 'center',
  },
  bodyStatus: {
    flex: 1,
    display: 'flex',
    justifyContent: 'center',
  },
  totalCalories: {
    flex: 1,
    display: 'flex',
    justifyContent: 'center',
  },
  topBackground: {
    backgroundColor: '#353535',
    borderBottomLeftRadius: 600,
    borderBottomRightRadius: 600,
    width: 950,
    alignSelf: 'center',
  },
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
