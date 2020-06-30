import React, {useState} from 'react';
import {
  View,
  Button,
  TextInput,
  StyleSheet,
  TouchableOpacity,
  TouchableHighlight,
  Text,
  ToastAndroid,
} from 'react-native';
import {Actions} from 'react-native-router-flux';
import AsyncStorage from '@react-native-community/async-storage';
import Axios from 'axios';
import Icon from 'react-native-vector-icons/MaterialIcons';
import Logo from './Logo';

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const login = () => {
    if (email === '') {
      ToastAndroid.show('Email is required !', ToastAndroid.SHORT);
      return;
    }
    if (password === '') {
      ToastAndroid.show('Password is required !', ToastAndroid.SHORT);
      return;
    }
    Axios.post('http://10.0.2.2:8080/login', {
      email: email,
      password: password,
    })
      .then(response => {
        AsyncStorage.setItem('access_token', response.data)
          .then(() => Actions.replace('home'))
          .catch(error => alert(error));
      })
      .catch(error =>
        ToastAndroid.show(
          'Email or password is incorrect !',
          ToastAndroid.SHORT,
        ),
      );
  };
  return (
    <View style={styles.container}>
      <Logo />

      <View style={styles.inputContainer}>
        <Icon style={styles.placeholderIcon} name="mail" size={25} />
        <TextInput
          placeholder="Email"
          onChangeText={value => setEmail(value)}
          style={styles.input}
          placeholderTextColor="#aaaaaa"
        />
      </View>

      <View style={styles.inputContainer}>
        <Icon style={styles.placeholderIcon} name="lock" size={25} />
        <TextInput
          placeholder="Password"
          onChangeText={value => setPassword(value)}
          style={styles.input}
          placeholderTextColor="#aaaaaa"
          secureTextEntry={true}
        />
      </View>

      <TouchableOpacity onPress={login} style={styles.loginButton}>
        <Text style={styles.loginText}>Login</Text>
      </TouchableOpacity>

      <TouchableOpacity
        style={styles.registerContainer}
        onPress={() => Actions.push('register')}>
        <Text style={styles.registerText}>Create an Account</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#353535',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
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
    width: '60%',
  },
  loginButton: {
    marginTop: 40,
    backgroundColor: 'rgb(0, 190, 90)',
    width: '70%',
    paddingVertical: 10,
    borderRadius: 25,
  },
  loginText: {
    color: 'white',
    textAlign: 'center',
    fontSize: 18,
    textTransform: 'uppercase',
    fontWeight: 'bold',
  },
  registerContainer: {marginTop: 30, borderRadius: 20},
  registerText: {
    color: 'white',
    fontSize: 15,
    padding: 6,
  },
});

export default LoginPage;
