package info.maila.lang

import org.junit.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertTrue
import kotlin.text.Charsets.ISO_8859_1
import kotlin.text.Charsets.UTF_8

class EncodingDetectorTest {

    @Test
    fun detectEncoding() {
        mapOf(
            "ISO-8859-1.txt" to ISO_8859_1,
            "UTF-8.txt" to UTF_8
        ).forEach { (fileName, encoding) ->
            val bytes = readAllBytes(fileName = fileName)
            val encodings = EncodingDetector.detectEncoding(bytes)
            assertTrue(actual = encodings.contains(encoding))
        }
    }

    @Test
    fun stringWithDetectedEncoding() {
    }

    companion object {
        private fun readAllBytes(fileName: String) = Files.readAllBytes(Paths.get(EncodingDetectorTest::class.java.getResource(fileName).toURI()))
    }

}
