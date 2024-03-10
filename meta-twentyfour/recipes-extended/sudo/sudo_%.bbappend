FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://sudoers.twentyfour \
"

# Explicitly require pam
inherit features_check

REQUIRED_DISTRO_FEATURES = "pam"

do_install:append () {
    install -m 0755 -d ${D}${sysconfdir}/sudoers.d
    install -m 0440 ${WORKDIR}/sudoers.twentyfour ${D}${sysconfdir}/sudoers.d/50-twentyfour
    chmod 4755 ${D}${bindir}/sudo
}