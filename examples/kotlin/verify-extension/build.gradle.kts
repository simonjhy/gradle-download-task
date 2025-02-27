/**
 * Include the gradle-download-task plugin
 */
plugins {
    id("de.undercouch.download") version "5.1.0"
}

/**
 * Use the extension to download and verify a single file
 */
tasks.register("downloadAndVerifyFile") {
    doLast {
        download.run {
            src("http://www.example.com/index.html")
            dest(buildDir)
            overwrite(true)
        }
        verifyChecksum.run {
            src(File(buildDir, "index.html"))
            algorithm("MD5")
            checksum("84238dfc8092e5d9c0dac8ef93371a07")
        }
    }
}

defaultTasks("downloadAndVerifyFile")
