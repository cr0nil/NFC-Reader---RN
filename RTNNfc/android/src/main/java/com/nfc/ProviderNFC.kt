package com.nfc
import android.nfc.tech.IsoDep
import com.github.devnied.emvnfccard.enums.SwEnum;
import com.github.devnied.emvnfccard.exception.CommunicationException;
import com.github.devnied.emvnfccard.parser.IProvider;
import com.github.devnied.emvnfccard.utils.TlvUtil;
import java.io.IOException
import java.nio.ByteBuffer;

class ProviderNFC : IProvider {

    private lateinit var mTagCom: IsoDep

    @Throws(CommunicationException::class)
    override fun transceive(pCommand: ByteArray?): ByteArray? {
        var response: ByteArray? = null
        try {
            // send command to emv card
            if (mTagCom.isConnected) {
                response = mTagCom.transceive(pCommand)
            }
        } catch (e: IOException) {
            throw CommunicationException(e.message)
        }
        return response
    }

    override fun getAt(): ByteArray {
        var result: ByteArray?
        result = mTagCom.historicalBytes // for tags using NFC-B
        if (result == null) {
            result = mTagCom.hiLayerResponse // for tags using NFC-B
        }
        return result
    }

    fun setmTagCom(mTagCom: IsoDep) {
        this.mTagCom = mTagCom
    }
}