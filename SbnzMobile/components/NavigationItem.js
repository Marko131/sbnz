import React from 'react';
import {TouchableHighlight, StyleSheet} from 'react-native';
import Icon from 'react-native-vector-icons/MaterialCommunityIcons';

const NavigationItem = props => {
  return (
    <TouchableHighlight style={styles.container} onPress={props.click}>
      <Icon name={props.icon} size={25} color="#353535" />
    </TouchableHighlight>
  );
};

const styles = StyleSheet.create({
  container: {
    backgroundColor: 'rgb(0, 190, 89)',
    borderRadius: 20,
    padding: 5,
    marginHorizontal: 15,
  },
});
export default NavigationItem;
