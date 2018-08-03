java -jar selenium-server-standalone-3.9.1.jar -role hub &
java -Dwebdriver.chrome.driver=chromedriver -jar selenium-server-standalone-3.9.1.jar -port 4457 -role node -hub http://localhost:4444/grid/register -browser "browserName=chrome" &
cd nodes-config
appium --nodeconfig ./ios-node.json -p 4455 -cp 4455 &
appium --nodeconfig ./android-node.json -p 4456 -cp 4456 &
cd ~/Library/Android/sdk/tools/
./emulator -avd "Android_Emulator_API_22" &




