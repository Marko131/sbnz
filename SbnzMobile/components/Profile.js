import React, {useState, useEffect} from 'react';
import {
  View,
  Text,
  StyleSheet,
  TextInput,
  TouchableOpacity,
  ToastAndroid,
} from 'react-native';
import Icon from 'react-native-vector-icons/MaterialIcons';
import {Picker} from '@react-native-community/picker';
import Axios from 'axios';
import AsyncStorage from '@react-native-community/async-storage';

const Profile = props => {
  const [age, setAge] = useState(0);
  const [height, setHeight] = useState(0);
  const [weight, setWeight] = useState(0);
  const [activity, setActivity] = useState('ACTIVE');

  const submit = async () => {
    const value = await AsyncStorage.getItem('access_token');
    if (value !== null) {
      if (age < 15 || age > 80) {
        ToastAndroid.show(
          'Please provide an age between 15 and 80',
          ToastAndroid.SHORT,
        );
        return;
      }
      if (weight < 1) {
        ToastAndroid.show('Positive numbers only', ToastAndroid.SHORT);
        return;
      }
      if (height < 1) {
        ToastAndroid.show('Positive numbers only', ToastAndroid.SHORT);
        return;
      }
      Axios.post(
        'http://10.0.2.2:8080/profile',
        {
          age: +age,
          height: +height,
          weight: +weight,
          activity: activity,
        },
        {headers: {'X-Auth-Token': value}},
      )
        .then(response => props.refresh())
        .catch(error => alert(error));
    }
  };

  useEffect(() => {
    props.profile ? setAge(props.profile.age) : 0;
    props.profile ? setHeight(props.profile.height) : 0;
    props.profile ? setWeight(props.profile.weight) : 0;
    props.profile ? setActivity(props.profile.activity) : 'ACTIVE';
  }, []);

  return (
    <View style={{flex: 1}}>
      <Text style={styles.header}> User Profile </Text>

      <View style={styles.inputContainer}>
        <Text style={styles.name}>
          {props.profile
            ? `${props.profile.firstName} ${props.profile.lastName}`
            : ''}
        </Text>
      </View>

      <View style={styles.inputContainer}>
        <Icon style={styles.placeholderIcon} name="poll" size={25} />
        <TextInput
          style={[styles.input, styles.width3]}
          keyboardType="numeric"
          placeholder="Age"
          placeholderTextColor="#aaaaaa"
          value={age.toString()}
          onChangeText={value => setAge(value)}
        />
        <TextInput
          style={[styles.input, styles.width3]}
          keyboardType="numeric"
          placeholder="Height"
          placeholderTextColor="#aaaaaa"
          value={height.toString()}
          onChangeText={value => setHeight(value)}
        />
        <TextInput
          style={[styles.input, styles.width3]}
          keyboardType="numeric"
          placeholder="Weight"
          placeholderTextColor="#aaaaaa"
          value={weight.toString()}
          onChangeText={value => setWeight(value)}
        />
      </View>

      <View style={styles.inputContainer}>
        <Icon style={styles.placeholderIcon} name="directions-run" size={25} />
        <Picker
          style={[styles.input, styles.width1]}
          placeholder="Activity"
          selectedValue={activity}
          onValueChange={(itemValue, itemIndex) => setActivity(itemValue)}>
          <Picker.Item label="Sedentary" value="SEDENTARY" />
          <Picker.Item label="Light" value="LIGHT" />
          <Picker.Item label="Moderate" value="MODERATE" />
          <Picker.Item label="Active" value="ACTIVE" />
          <Picker.Item label="Very active" value="VERY_ACTIVE" />
          <Picker.Item label="Extra active" value="EXTRA_ACTIVE" />
        </Picker>
      </View>

      <TouchableOpacity style={styles.button} onPress={() => submit()}>
        <Text style={styles.buttonText}>update</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  header: {
    color: 'white',
    textAlign: 'center',
    fontSize: 20,
    padding: 10,
    textTransform: 'uppercase',
    fontWeight: 'bold',
  },
  inputContainer: {
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
  },
  placeholderIcon: {
    color: 'rgb(0, 190, 90)',
    marginRight: 10,
  },
  input: {
    color: 'white',
    fontSize: 18,
    marginVertical: 5,
    borderBottomColor: 'rgb(0, 190, 90)',
    borderTopColor: 'transparent',
    borderLeftColor: 'transparent',
    borderRightColor: 'transparent',
    borderWidth: 1,
    marginHorizontal: 5,
  },
  width1: {width: '79%'},
  width2: {
    width: '39%',
  },
  width3: {width: '25%'},
  name: {
    color: 'white',
    fontSize: 15,
    textTransform: 'uppercase',
  },
  button: {
    backgroundColor: 'white',
    paddingVertical: 10,
    marginTop: 'auto',
  },
  buttonText: {
    textAlign: 'center',
    textTransform: 'uppercase',
  },
});

export default Profile;
