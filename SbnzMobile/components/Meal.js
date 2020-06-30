import React from 'react';
import {View, Text, Image, StyleSheet, ImageBackground} from 'react-native';

const Meal = props => {
  return (
    <View style={styles.container}>
      <Text style={styles.header}>{props.meal.name}</Text>
      <Text style={styles.calorieText}>{props.meal.calories}</Text>
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    display: 'flex',
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginHorizontal: 10,
    backgroundColor: 'rgba(255, 255, 255, .2)',
    borderRadius: 20,
    marginVertical: 5,
    paddingVertical: 5,
    paddingHorizontal: 20,
  },
  header: {
    color: 'white',
    textAlign: 'center',
    fontSize: 20,
  },
  calorieText: {
    color: 'rgb(0, 190, 89)',
    fontWeight: 'bold',
  },
});
export default Meal;
