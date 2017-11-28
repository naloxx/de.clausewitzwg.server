package de.clausewitzwg.server.service

import de.clausewitzwg.server.ServerApplication
import org.nmap4j.Nmap4j
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class NetworkService {

    private val log = LoggerFactory.getLogger(ServerApplication::class.java)

    fun fullScan(): List<String> {
        val result = LinkedList<String>()

        val nmap = Nmap4j("/usr/local")
        nmap.includeHosts("192.168.178.1-255")
        nmap.addFlags("-sP")
        nmap.execute()
        if (!nmap.hasError()) {
            val nmapRun = nmap.result

            nmapRun.hosts.mapTo(result) { it.addresses[0].addr }
        } else {
            log.error(nmap.executionResults.errors)
        }

        return result

    }

}