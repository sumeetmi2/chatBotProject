# chatBotProject


1. create wit account and create story template. In the app setting you will find the AUTHENTICATION TOKEN.

2. The project basically has 5 action types and several intents.

3. 4 action types are MSG,ACTION,END,MERGE,FEEDBACK (first four are wit specific and last one is application specific)

4. intents have their own services written. If the intent service performs a task it implements WitPerformActionIntentService (this interface extends WitIntentService which has updateContext implementation)

5. Each Intent Service's task is to perform action and/or update context object (wit specific).

6. A context object is a map of key and value which is specific to wit. Its basically a key used to deviate the conversation template in a particular direction.

7. If wit is unable to find intent. The feedback loop is initiated which will ask from user to select from all available intents and then update the training material (understanding api) of the wit against that particular selcted intent


Things to do:

1. Implement garbage filter in feedback
2. Make the intent dynamic 
3. make chat templates more user friendly.

URL to get chat console : http://localhost:8080/DoEngine/bot 
