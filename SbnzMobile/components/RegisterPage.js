import React, {useState} from 'react';
import {
  View,
  Text,
  TextInput,
  StyleSheet,
  TouchableOpacity,
  ToastAndroid,
} from 'react-native';
import {Picker} from '@react-native-community/picker';
import Icon from 'react-native-vector-icons/MaterialIcons';
import Logo from './Logo';
import {Actions} from 'react-native-router-flux';
import Axios from 'axios';

const RegisterPage = () => {
  const [email, setEmail] = useState('');
  const [password1, setPassword1] = useState('');
  const [password2, setPassword2] = useState('');
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [age, setAge] = useState('');
  const [gender, setGender] = useState('MALE');
  const [height, setHeight] = useState('');
  const [weight, setWeight] = useState('');
  const [activity, setActivity] = useState('ACTIVE');
  const register = () => {
    console.log({
      email: email,
      password1: password1,
      password2: password2,
      firstName: firstName,
      lastName: lastName,
      age: +age,
      gender: gender,
      height: +height,
      weight: +weight,
      activity: activity,
    });
    if (
      email === '' ||
      password1 === '' ||
      password2 === '' ||
      firstName === '' ||
      lastName === '' ||
      age === '' ||
      gender === '' ||
      height === '' ||
      weight === '' ||
      activity === ''
    ) {
      ToastAndroid.show('All fields are required', ToastAndroid.SHORT);
      return;
    }

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

    Axios.post('http://10.0.2.2:8080/register', {
      email: email,
      password1: password1,
      password2: password2,
      firstName: firstName,
      lastName: lastName,
      age: +age,
      gender: gender,
      height: +height,
      weight: +weight,
      activity: activity,
    })
      .then(response => {
        console.log(response.data);
        ToastAndroid.show('Your account has been created', ToastAndroid.SHORT);
        Actions.replace('login');
      })
      .catch(error => {
        alert(error);
        console.log(error);
      });
  };
  return (
    <View style={styles.body}>
      <Text style={styles.heading}>Create account </Text>

      <View style={styles.inputContainer}>
        <Icon style={styles.placeholderIcon} name="mail" size={25} />
        <TextInput
          style={[styles.input, styles.width1]}
          placeholder="Email"
          placeholderTextColor="#aaaaaa"
          onChangeText={value => setEmail(value)}
        />
      </View>

      <View style={styles.inputContainer}>
        <Icon style={styles.placeholderIcon} name="lock" size={25} />
        <TextInput
          style={[styles.input, styles.width1]}
          placeholder="Password"
          placeholderTextColor="#aaaaaa"
          onChangeText={value => setPassword1(value)}
          secureTextEntry={true}
        />
      </View>

      <View style={styles.inputContainer}>
        <Icon style={styles.placeholderIcon} name="lock" size={25} />
        <TextInput
          style={[styles.input, styles.width1]}
          placeholder="Confirm password"
          placeholderTextColor="#aaaaaa"
          onChangeText={value => setPassword2(value)}
          secureTextEntry={true}
        />
      </View>

      <View style={styles.inputContainer}>
        <Icon style={styles.placeholderIcon} name="person" size={25} />
        <TextInput
          style={[styles.input, styles.width2]}
          placeholder="First name"
          placeholderTextColor="#aaaaaa"
          onChangeText={value => setFirstName(value)}
        />
        <TextInput
          style={[styles.input, styles.width2]}
          placeholder="Last name"
          placeholderTextColor="#aaaaaa"
          onChangeText={value => setLastName(value)}
        />
      </View>

      <View style={styles.inputContainer}>
        <Icon style={styles.placeholderIcon} name="poll" size={25} />
        <TextInput
          style={[styles.input, styles.width3]}
          keyboardType="numeric"
          placeholder="Age"
          placeholderTextColor="#aaaaaa"
          onChangeText={value => setAge(value)}
        />
        <TextInput
          style={[styles.input, styles.width3]}
          keyboardType="numeric"
          placeholder="Height"
          placeholderTextColor="#aaaaaa"
          onChangeText={value => setHeight(value)}
        />
        <TextInput
          style={[styles.input, styles.width3]}
          keyboardType="numeric"
          placeholder="Weight"
          placeholderTextColor="#aaaaaa"
          onChangeText={value => setWeight(value)}
        />
      </View>

      <View style={styles.inputContainer}>
        <Icon style={styles.placeholderIcon} name="directions-run" size={25} />
        <Picker
          style={[styles.input, styles.width2]}
          placeholder="Gender"
          selectedValue={gender}
          onValueChange={(itemValue, itemIndex) => setGender(itemValue)}>
          <Picker.Item label="Male" value="MALE" />
          <Picker.Item label="Female" value="FEMALE" />
        </Picker>

        <Picker
          style={[styles.input, styles.width2]}
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

      <TouchableOpacity onPress={register} style={styles.registerButton}>
        <Text style={styles.registerText}>Register</Text>
      </TouchableOpacity>

      <TouchableOpacity
        style={styles.loginContainer}
        onPress={() => Actions.replace('login')}>
        <Text style={styles.loginText}>Already have an account? Login</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  body: {
    flex: 1,
    backgroundColor: '#353535',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
  },
  heading: {
    fontSize: 35,
    marginBottom: 40,
    fontWeight: 'bold',
    color: 'rgb(0, 190, 90)',
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
  test: {backgroundColor: 'red'},
  registerButton: {
    marginTop: 40,
    backgroundColor: 'rgb(0, 190, 90)',
    width: '70%',
    paddingVertical: 10,
    borderRadius: 25,
  },
  registerText: {
    color: 'white',
    textAlign: 'center',
    fontSize: 18,
    textTransform: 'uppercase',
    fontWeight: 'bold',
  },
  loginContainer: {marginTop: 30, borderRadius: 20},
  loginText: {
    color: 'white',
    fontSize: 15,
    padding: 6,
  },
});

export default RegisterPage;
