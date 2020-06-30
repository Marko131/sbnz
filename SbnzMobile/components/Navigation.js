import React from 'react';
import {View, StyleSheet, ToastAndroid} from 'react-native';
import NavigationItem from './NavigationItem';
import AsyncStorage from '@react-native-community/async-storage';
import {Actions} from 'react-native-router-flux';
import Notifications from './Notifications';

const Navigation = props => {
  const logout = () => {
    AsyncStorage.removeItem('access_token');
    Actions.replace('login');
  };
  return (
    <View style={styles.container}>
      {/* <NavigationItem icon="chart-bar" /> */}
      <NavigationItem
        icon="account"
        click={() => ToastAndroid.show('Profile', ToastAndroid.SHORT)}
      />
      <NavigationItem
        icon="food-variant"
        click={() => props.setDefaultView()}
      />
      <NavigationItem
        icon="android-messages"
        click={() => props.changeView(<Notifications />)}
      />
      <NavigationItem icon="refresh" click={props.refresh} />
      <NavigationItem icon="logout" click={logout} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    display: 'flex',
    justifyContent: 'center',
    flexDirection: 'row',
    marginTop: 30,
    marginBottom: 20,
  },
  text: {
    color: 'white',
  },
});

export default Navigation;
