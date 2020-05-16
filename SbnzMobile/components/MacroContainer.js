import React from 'react';
import {View, Text, StyleSheet} from 'react-native';
import * as Progress from 'react-native-progress';
import MacroProgress from './MacroProgress';

const width = 100;

const MacroContainer = () => {
  return (
    <View style={styles.container}>
      <MacroProgress macro="CARBS" progress={0.67} grams={42} marginTop={-30} />
      <MacroProgress macro="PROTEIN" progress={0.8} grams={33} />
      <MacroProgress macro="FAT" progress={0.9} grams={13} marginTop={-30} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    marginTop: 30,
    display: 'flex',
    flexDirection: 'row',
    justifyContent: 'center',
  },
});

export default MacroContainer;
