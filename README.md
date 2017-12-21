# NodeInfo

Allows one to get some rudimentary information about a running Corda node via RPC

Useful for debugging network issues, ensuring flows have loaded etc.

After cloning, use the _getInfo_ gradle task to retrieve node information.

## How to install and run

```
git clone https://github.com/ragmondo/corda-nodeinfo.git
cd corda-nodeinfo
./gradlew getInfo -Phost="localhost:10003" -Pusername="corda" -Ppassword="corda_initial_password"
```
  
  
## Sample Output
  
```
richardgreen@MEGATRON ~/c/corda-nodeinfo> ./gradlew getInfo -Phost="localhost:10009" -Pusername="corda" -Ppassword="corda_initial_password"

> Task :getInfo
Logging into localhost:10009 as corda
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Node connected: C=IT,L=Rome,O=CorpB
Time: 2017-12-05T10:02:54.575Z.
Flows: [net.corda.cordaftp.TxFileInitiator, net.corda.core.flows.ContractUpgradeFlow$Authorise, net.corda.core.flows.ContractUpgradeFlow$Deauthorise, net.corda.core.flows.ContractUpgradeFlow$Initiate]
Platform version: 1
Current Network Map Status -->
-- C=IT,L=Rome,O=CorpB @ 127.0.0.1
-- C=US,L=New York,O=CorpC @ 127.0.0.1
-- C=FR,L=Paris,O=CorpA @ 127.0.0.1
-- C=GB,L=London,O=Controller @ 127.0.0.1
-- C=NL,L=Amsterdam,O=Network Map Service @ localhost
Registered Notaries -->
-- C=GB,L=London,O=Controller,CN=corda.notary.simple
```
  
  
  
## Errors


`Exception in thread "main" ActiveMQSecurityException[errorType=SECURITY_EXCEPTION message=AMQ119031: Unable to validate user]` 

Caused by: Wrong RPC Credentials. Check the node.conf file and try again.

`Exception in thread "main" ActiveMQNotConnectedException[errorType=NOT_CONNECTED message=AMQ119007: Cannot connect to server(s). Tried with all available servers.]`

Caused by: Network connectivity issues or node not running. 
