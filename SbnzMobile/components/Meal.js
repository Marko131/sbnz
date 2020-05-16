import React from 'react';
import {View, Text, Image, StyleSheet} from 'react-native';

const Meal = props => {
  return (
    <View style={styles.container}>
      <Image
        style={{width: 180, height: 280, borderRadius: 20}}
        source={{
          uri: props.imageUrl,
        }}
      />
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    marginHorizontal: 10,
  },
});
export default Meal;
