fastlane documentation
================
# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```
xcode-select --install
```

Install _fastlane_ using
```
[sudo] gem install fastlane -NV
```
or alternatively using `brew cask install fastlane`

# Available Actions
## Android
### android assemble_build
```
fastlane android assemble_build
```
Assemble Build
### android unit_tests
```
fastlane android unit_tests
```
Run Unit Tests
### android instrumentation_tests_testlab
```
fastlane android instrumentation_tests_testlab
```
Run UI Test in Firebase Test Lab
### android send_apk_to_slack
```
fastlane android send_apk_to_slack
```
Send Apk to Slack
### android beta
```
fastlane android beta
```
Beta Deployment
### android release
```
fastlane android release
```
Release Deployment

----

This README.md is auto-generated and will be re-generated every time [fastlane](https://fastlane.tools) is run.
More information about fastlane can be found on [fastlane.tools](https://fastlane.tools).
The documentation of fastlane can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
