mvn clean install -P domain-test -Dwebdriver.driver=phantomjs -Dwebdriver.base.url=http://www.google.co.uk/ -Dtest.tagnames=AbsDataProcessIndex -Dmaven.test.skip=false -Dtest.threadcount=1


Oberserved the below lines are printed in my jenkins console :
[INFO  - 2017-05-17T15:19:00.974Z] SessionManagerReqHand - _cleanupWindowlessSessions - Asynchronous Sessions clean-up phase starting NOW
[INFO  - 2017-05-17T15:24:00.975Z] SessionManagerReqHand - _cleanupWindowlessSessions - Asynchronous Sessions clean-up phase starting NOW
[INFO  - 2017-05-17T15:29:00.975Z] SessionManagerReqHand - _cleanupWindowlessSessions - Asynchronous Sessions clean-up phase starting NOW

But still finally it displayed :

java.lang.StackOverflowError: null
	at net.thucydides.core.model.TestStep.renumberChildrenFrom(TestStep.java:84)
	at net.thucydides.core.model.TestStep.renumberFrom(TestStep.java:78)
	at net.thucydides.core.model.TestStep.renumberChildrenFrom(TestStep.java:85)
	at net.thucydides.core.model.TestStep.renumberFrom(TestStep.java:78)
	at net.thucydides.core.model.TestStep.renumberChildrenFrom(TestStep.java:85)
	at net.thucydides.core.model.TestStep.renumberFrom(TestStep.java:78)
	at net.thucydides.core.model.TestStep.renumberChildrenFrom(TestStep.java:85)
	at net.thucydides.core.model.TestStep.renumberFrom(TestStep.java:78)
	at net.thucydides.core.model.TestStep.renumberChildrenFrom(TestStep.java:85)
	at net.thucydides.core.model.TestStep.renumberFrom(TestStep.java:78)
	at net.thucydides.core.model.TestStep.renumberChildrenFrom(TestStep.java:85)
	at net.thucydides.core.model.TestStep.renumberFrom(TestStep.java:78)
	at net.thucydides.core.model.TestStep.renumberChildrenFrom(TestStep.java:85)
	at net.thucydides.core.model.TestStep.renumberFrom(TestStep.java:78)
