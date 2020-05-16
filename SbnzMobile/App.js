/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {useState} from 'react';
import {Text, AsyncStorage, Button} from 'react-native';
import HomePage from './components/HomePage';
import LoginPage from './components/LoginPage';
import {Router, Stack, Scene} from 'react-native-router-flux';
const App = () => {
  const [accessToken, setAccessToken] = useState(null);

  return (
    <Router>
      <Stack key="root">
        <Scene key="home" component={HomePage} hideNavBar={true} />
        <Scene key="login" component={LoginPage} hideNavBar={true} />
      </Stack>
    </Router>
  );
};

export default App;
