package com.nfc;
import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider

class NfcPackage : TurboReactPackage() {

  override fun getModule(
        s: String,
        reactApplicationContext: ReactApplicationContext
    ): NativeModule? {
        when (s) {
            NfcModule.NAME -> return NfcModule(reactApplicationContext)
        }
        return null
    }


 override fun getReactModuleInfoProvider() = ReactModuleInfoProvider {
   mapOf(
     NfcModule.NAME to ReactModuleInfo(
       NfcModule.NAME,
       NfcModule.NAME,
       false, // canOverrideExistingModule
       false, // needsEagerInit
       true, // hasConstants
       false, // isCxxModule
       true // isTurboModule
     )
   )
 }
}