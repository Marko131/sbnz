import React from 'react';
import {View, Text, StyleSheet} from 'react-native';
import * as Progress from 'react-native-progress';

const width = 100;

const MacroProgress = props => {
  return (
    <View style={{marginTop: props.marginTop, marginHorizontal: 20}}>
      <Text style={styles.text}>{props.macro}</Text>
      <Progress.Bar
        progress={props.progress}
        width={200}
        color="rgba(0, 255, 152, 1)"
        unfilledColor="rgb(0, 106, 63)"
        borderWidth={0}
        width={width}
        height={8}
        borderRadius={15}
      />
      <Text style={styles.text}>{props.grams}g left</Text>
    </View>
  );
};
const styles = StyleSheet.create({
  text: {
    color: 'white',
    textAlign: 'center',
    marginVertical: 5,
  },
});
export default MacroProgress;
