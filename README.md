# TwentyFour distro

## Raspberry Pi Zero Wireless
Create a simple, small, robust, secure & fast distro for Raspberry Pi Zero Wireless.

## Getting started

```bash
$ git clone https://github.com/ooonak/meta-twentyfour
$ cd meta-twentyfour
$ run-kas checkout --force-checkout rpi0.yaml
$ run-kas dump --lock --inplace --update rpi0.yaml
$ run-kas shell rpi0.yaml

build$ bitbake -c build twentyfour-console-image 
```
