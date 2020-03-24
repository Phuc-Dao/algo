Rest vs RPC vs GraphQL
1. RPC is used to invoke system calls in a remote server (calling a function)
2. Less overhead when sending payload ()

cons of rpc:
1. Tight coupling of the system
2. Function explosions -- It is easy to create new apis, so new apis are created so easily (low quality)


Rest
1. Tries to decouple the client and the server as much as possible
2. Model resources instead of function calls
3. 

cons
1. Big payloads (large overhead)
2. chattiness

How to scale out processing
2. DNS(Round Robin)
    - Maps different servers to a single ip-address
    - Uses Round Robin to select which replicate server it gets sent to
    - Advntage: Relies on pre-existing infrastructure (Everything is there)
    - Disadvantage: If one of the servers crashes, then the user is waiting on a response
3. LoadBalancers
    -  Have a server with public ip-address
    - Forwards requests to a tier of processing using Network address translations 
    - Layer 4 (Network layer)
        a. Takes incoming packets, and routes it to a server (by modifying the src and destination field in http)

Availability Metrics
* Mean time before failure
    - How long in between failures
* Mean time to repair
* (Mean time to repair) How long after a failure occures for us to repair
* Availability = (MTBF - MTTR) / MTBF


Harvest and yield
yield = queries completed/queries offereterd
harvest = data availabl/completed data













