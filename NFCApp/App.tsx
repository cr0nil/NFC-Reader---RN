import React from 'react';
import {useState} from 'react';
import {SafeAreaView, StatusBar, Text, Button} from 'react-native';
import RTNNfc from 'nfc-reader/js/NativeNfc';

const App: () => JSX.Element = () => {
  const [result, setResult] = useState<number | null>(null);
  return (
    <SafeAreaView>
      <StatusBar barStyle={'dark-content'} />
      <Text style={{marginLeft: 20, marginTop: 20}}>3+7={result ?? '??'}</Text>
      <Button
        title="Compute"
        onPress={async () => {
          try {
            const value = await RTNNfc?.add(3, 7);
            console.log('value', value);
          } catch (e) {
            console.log('error', e);
          }

          // setResult(value ?? null);
        }}
      />
    </SafeAreaView>
  );
};
export default App;
