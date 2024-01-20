package com.nfc
import android.nfc.NfcAdapter
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.nfc.NativeNfcSpec
import com.nfc.ProviderNFC
import com.github.devnied.emvnfccard.exception.CommunicationException
import com.github.devnied.emvnfccard.model.EmvCard
import com.github.devnied.emvnfccard.parser.EmvTemplate
import com.github.devnied.emvnfccard.parser.EmvTemplate.Config
import com.github.devnied.emvnfccard.parser.IProvider
import android.util.Log

class NfcModule(reactContext: ReactApplicationContext) : NativeNfcSpec(reactContext) {

  override fun getName() = NAME
  private var mNfcAdapter: NfcAdapter? = null

  override fun add(a: Double, b: Double, promise: Promise) {
  try {
          val provider: IProvider = ProviderNFC()
        val config: Config = EmvTemplate.Config()
            .setContactLess(true) // Enable contact less reading (default: true)
            .setReadAllAids(true) // Read all aids in card (default: true)
            .setReadTransactions(true) // Read all transactions (default: true)
            .setReadCplc(false) // Read and extract CPCLC data (default: false)
            .setRemoveDefaultParsers(false) // Remove default parsers for GeldKarte and EmvCard (default: false)
            .setReadAt(true) // Read and extract ATR/ATS and description

		val parser = EmvTemplate.Builder() //
            .setProvider(provider) // Define provider
            .setConfig(config) // Define config
            //.setTerminal(terminal) (optional) you can define a custom terminal implementation to create APDU
            .build()
// Read card
  val card: EmvCard = parser.readEmvCard()
     Log.i("this",""+card)
         promise.resolve(card)
        } catch (e: Error) {
               promise.reject(e)
        }


  }
  

  companion object {
    const val NAME = "RTNNfc"
  }
}