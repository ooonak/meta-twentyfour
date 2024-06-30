# This recipe is based on core-image-minimal.

SUMMARY = "TwentyFour console image"

IMAGE_FEATURES = " \
  overlayfs-etc \
  read-only-rootfs \
  hwcodecs \
  ssh-server-openssh \
  "

IMAGE_FEATURES:append = " \
  tools-debug \
  tools-testapps \
  "

IMAGE_INSTALL = "packagegroup-core-boot"

IMAGE_INSTALL:append = " rauc"

IMAGE_LINGUAS = " "

INIT_MANAGER = "systemd"

# Vulnerability check at build time
INHERIT += "cve-check"

# Create Software Bill of Materials
INHERIT += "create-spdx"

require include/users.inc

inherit core-image