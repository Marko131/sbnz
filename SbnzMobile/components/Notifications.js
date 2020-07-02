import React, {useEffect, useState} from 'react';
import {View, Text, StyleSheet} from 'react-native';
import AsyncStorage from '@react-native-community/async-storage';
import Axios from 'axios';
import {ScrollView} from 'react-native-gesture-handler';

const Notifications = () => {
  const [notification, setNotification] = useState(null);

  useEffect(() => {
    getNotifications();
  }, []);

  const getNotifications = async () => {
    try {
      const value = await AsyncStorage.getItem('access_token');
      if (value !== null) {
        Axios.get('http://10.0.2.2:8080/notification', {
          headers: {'X-Auth-Token': value},
        })
          .then(response => {
            setNotification(response.data);
            console.log(response.data);
          })
          .catch(error => console.log(error));
      }
    } catch (error) {
      alert('Unexpected error');
    }
  };
  const showNotifications = () => {
    if (!notification) return;
    console.log(notification);
    return notification.text.map((text, index) => (
      <Text style={styles.notification} key={index}>
        {' '}
        {text}{' '}
      </Text>
    ));
  };
  return (
    <ScrollView>
      <Text style={styles.header}> Notifications </Text>
      {showNotifications()}
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  header: {
    color: 'white',
    textAlign: 'center',
    padding: 10,
    fontSize: 20,
    textTransform: 'uppercase',
    fontWeight: 'bold',
  },
  notification: {
    color: 'white',
    backgroundColor: 'rgba(255, 255, 255, .2)',
    marginHorizontal: 10,
    marginVertical: 10,
    padding: 10,
    borderRadius: 20,
  },
});

export default Notifications;
