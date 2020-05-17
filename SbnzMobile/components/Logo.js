import React from 'react';
import {View, Text, StyleSheet} from 'react-native';

const Logo = () => {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Cc</Text>
      <Text style={styles.subtitle}>CalorieCounter</Text>
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    padding: 40,
    marginBottom: 60,
    borderWidth: 15,
    borderColor: 'rgb(0, 220, 120)',
    borderRadius: 150,
  },
  logoContainer: {display: 'flex', flexDirection: 'row'},
  title: {
    color: 'rgb(0, 250, 120)',
    fontSize: 130,
    fontWeight: 'bold',
    textAlign: 'center',
    textShadowColor: 'rgba(0, 255, 150, 0.75)',
    textShadowOffset: {width: 0, height: 0},
    textShadowRadius: 30,
    marginTop: -25,
    fontFamily: 'monospace',
  },
  subtitle: {
    color: 'rgb(0, 220, 120)',
    fontSize: 25,
    textAlign: 'center',
    marginTop: -25,
    fontWeight: 'bold',
  },
});

export default Logo;
