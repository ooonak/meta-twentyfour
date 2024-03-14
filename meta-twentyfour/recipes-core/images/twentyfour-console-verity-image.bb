# This recipe is based on core-image-minimal.

SUMMARY = "TwentyFour console image"

IMAGE_FEATURES = "read-only-rootfs hwcodecs ssh-server-dropbear "

IMAGE_INSTALL = "packagegroup-core-boot"

IMAGE_LINGUAS = " "

INIT_MANAGER = "mdev-busybox"

# Vulnerability check at build time
INHERIT += "cve-check"

# Create Software Bill of Materials
INHERIT += "create-spdx"

require include/users.inc

FILESEXTRAPATHS:prepend := "${BBPATH}/../meta-twentyfour:"
SRC_URI = "file://wic/hdd-verity-wic.wks"

IMAGE_INSTALL:append = " cryptsetup"

DM_VERITY_IMAGE = "twentyfour-console-verity-image"
DM_VERITY_IMAGE_TYPE = "squashfs"
IMAGE_CLASSES += "dm-verity-img"
IMAGE_FSTYPES = "squashfs squashfs.verity wic"
WICVARS:append = "DM_VERITY_IMAGE DM_VERITY_IMAGE_TYPE"

inherit core-image

WKS_FILE = "my-image.wks"

WKS_FILE_DEPENDS = "dosfstools-native mtools-native gptfdisk-native squashfs-tools-native"
WKS_FILE_DEPENDS:append:x86 = " syslinux-native syslinux"
WKS_FILE_DEPENDS:append:x86-64 = " syslinux-native syslinux"
WKS_FILE_DEPENDS:append:x86-x32 = " syslinux-native syslinux"

QB_KERNEL_CMDLINE:APPEND = "root=/dev/vda1 rootrw=/dev/vda2 rootrwoptions=rw,noatime init=/init"
QB_DEFAULT_FSTYPE = "wic"
QB_FSINFO = "wic:no-kernel-in-fs"
