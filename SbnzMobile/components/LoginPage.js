import React, {useState} from 'react';
import {View, Text, Button, TextInput} from 'react-native';
import {Actions} from 'react-native-router-flux';
import AsyncStorage from '@react-native-community/async-storage';
import Axios from 'axios';

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const login = () => {
    Axios.post('http://10.0.2.2:8080/login', {
      email: email,
      password: password,
    })
      .then(response => {
        console.log(response.data);

        AsyncStorage.setItem('access_token', response.data)
          .then(() => Actions.replace('home'))
          .catch(error => alert(error));
      })
      .catch(error => alert(error));
  };
  return (
    <View>
      <Text>LoginPage</Text>
      <TextInput onChangeText={value => setEmail(value)} />
      <TextInput onChangeText={value => setPassword(value)} />
      <Button title="Login" onPress={login} />
    </View>
  );
};

export default LoginPage;
