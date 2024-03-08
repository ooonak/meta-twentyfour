# This recipe is based on core-image-minimal.

SUMMARY = "TwentyFour console image"

IMAGE_FEATURES = "read-only-rootfs hwcodecs ssh-server-dropbear"

IMAGE_INSTALL = "packagegroup-core-boot"

IMAGE_LINGUAS = " "

INIT_MANAGER = "mdev-busybox"

inherit core-image