#!/usr/bin/env bash

curl -F token=xoxp-474526796610-473921783169-555578726836-5aa8b4ad476a130b89634de997c2fdf9 -F channels=CDYAFET1A -F file=@../app/build/outputs/apk/debug/app-debug.apk https://slack.com/api/files.upload