import React from 'react';
import {
  View,
  Text,
  StyleSheet,
  TouchableHighlight,
  TouchableOpacity,
} from 'react-native';
import NavigationItem from './NavigationItem';
const Navigation = () => {
  return (
    <View style={styles.container}>
      <NavigationItem icon="account" />
      <NavigationItem icon="chart-bar" />
      <NavigationItem icon="food-variant" />
      <NavigationItem icon="settings" />
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
