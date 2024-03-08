# My distro

## Getting started

Below builds for building qemu-arm, replace kas file with rpi.yaml to build for Raspberry Pi.

```bash
$ git clone https://github.com/ooonak/my-pi-distro
$ cd my-pi-distro
$ run-kas checkout --force-checkout qemu-arm.yaml
$ run-kas dump --lock --inplace --update qemu-arm.yaml
$ run-kas shell qemu-arm.yaml

build$ bitbake -c build my-tiny-image 
```

## Raspberry Pi Zero Wireless
Create a simple, small, robust, secure & fast distro for Raspberry Pi Zero Wireless.
