mvn clean install -P domain-test -Dwebdriver.driver=phantomjs -Dwebdriver.base.url=http://europepmc.org/ -Dtest.tagnames=AbsDataProcessIndex -Dmaven.test.skip=false -Dtest.threadcount=1


Oberserved the below lines are printed in my jenkins console :
[INFO  - 2017-05-17T15:19:00.974Z] SessionManagerReqHand - _cleanupWindowlessSessions - Asynchronous Sessions clean-up phase starting NOW
[INFO  - 2017-05-17T15:24:00.975Z] SessionManagerReqHand - _cleanupWindowlessSessions - Asynchronous Sessions clean-up phase starting NOW
[INFO  - 2017-05-17T15:29:00.975Z] SessionManagerReqHand - _cleanupWindowlessSessions - Asynchronous Sessions clean-up phase starting NOW
