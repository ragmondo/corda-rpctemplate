package net.corda.rpctemplate

import net.corda.client.rpc.CordaRPCClient
import net.corda.core.messaging.CordaRPCOps
import net.corda.core.utilities.NetworkHostAndPort

/**
 * Template to write your own corda rpc app
 */
fun main(args: Array<String>) {
    if (args.size < 2) {
        throw RuntimeException("Usage: <Program> host:port username password (or via ./gradlew getInfo host:port username password)")
    }
    val host = args.get(0)
    val username = args.get(1)

    val password =
            if (args.size > 2) {
                args.get(2)
            } else {
                print("Password:")
                System.console().readPassword().joinToString(separator = "")
            }

    println("Logging into $host as $username")

    val proxy = loginToCordaNode(host, username, password)

    /* The rest of your code goes here */

    println("Node connected: ${proxy.nodeInfo().legalIdentities.first()}")

}

fun loginToCordaNode(host: String, username: String, password: String): CordaRPCOps {
    val nodeAddress = NetworkHostAndPort.parse(host)
    val client = CordaRPCClient(nodeAddress)
    return client.start(username, password).proxy
}

