FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://dmverity.cfg \
    file://squashfs.cfg \
"
