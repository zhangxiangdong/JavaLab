package me.zhang.io

import okio.GzipSink
import okio.Okio
import java.io.File

object Di {

    @JvmStatic
    fun main(args: Array<String>) {
        sink()
        gzipSink()
    }

    private fun sink() {
        val filePath = "/Users/admin/IdeaProjects/java-lab/workbench/.local/Test.txt"
        val file = File(filePath)
        val sink = Okio.buffer(Okio.sink(file))
        sink.writeUtf8(filePath)
        sink.flush()
        sink.close()

        println("Sink, file length: ${file.length()}")

    }

    private fun gzipSink() {
        val filePath = "/Users/admin/IdeaProjects/java-lab/workbench/.local/Test2.txt"
        val file = File(filePath)
        val gzipSink = Okio.buffer(GzipSink(Okio.sink(file)))
        gzipSink.writeUtf8(filePath)
        gzipSink.flush()
        gzipSink.close()

        println("GzipSink, file length: ${file.length()}")
    }

}