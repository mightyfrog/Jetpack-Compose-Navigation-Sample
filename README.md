# Jetpack Compose Navigation Sample

## Branches

- main
- with_args
- with_deeplink

---

## main

Base implementation

---

## with_args

Navigtation with arguments

---

## with_deeplink

Navigation using a deelplink

MainScreen displays "Hello" only when it's launched via the deeplink.

```shell
adb shell am start -a android.intent.action.VIEW -d "https://www.example.com?text=Hello" org.mightyfrog.android.jetpackcomposenavigationsample
```
