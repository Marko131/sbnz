import React from 'react';
import {View, Text, Image, StyleSheet, ImageBackground} from 'react-native';

const Meal = props => {
  return (
    <View style={styles.container}>
      <ImageBackground
        style={{width: 180, height: 280}}
        source={{
          uri: props.imageUrl,
        }}>
        <Text style={styles.header}>{props.meal.mealEnum}</Text>
      </ImageBackground>
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    marginHorizontal: 10,
  },
  header: {
    color: 'white',
    textAlign: 'center',
    fontSize: 20,
  },
});
export default Meal;
