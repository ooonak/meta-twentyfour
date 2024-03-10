# Extra hardening flags as recommended by SSF.
# poky/meta/conf/distro/include/security_flags.inc is enabled from distro conf.
# https://best.openssf.org/Compiler-Hardening-Guides/Compiler-Options-Hardening-Guide-for-C-and-C++.html

# Check what flags are actually used for C/C++ with:
# bitbake <image-name> -e |grep "^SECURITY_CFLAGS="
# bitbake <image-name> -e |grep "^export CC="

SECURITY_CFLAGS:append = " \
    -O2 -Wall -Wformat -Wformat=2 -Wconversion -Wimplicit-fallthrough \
    -U_FORTIFY_SOURCE -D_FORTIFY_SOURCE=3 \
    -D_GLIBCXX_ASSERTIONS \
    -fstrict-flex-arrays=3 \
    -fstack-clash-protection -fstack-protector-strong \
    -Wl,-z,nodlopen -Wl,-z,noexecstack \
    -Wl,-z,relro -Wl,-z,now \
    "

# for x86_64
# TODO SECURITY_CFLAGS:append = "-fcf-protection=full"

# for aarch64
# TODO SECURITY_CFLAGS:append = "-mbranch-protection=standard"

# for production code
SECURITY_CFLAGS:append = " \
    -fno-delete-null-pointer-checks -fno-strict-overflow \
    -fno-strict-aliasing -ftrivial-auto-var-init=zero\
    "

# for disabling obsolete C constructs
# -Werror=int-conversion makes things break.
SECURITY_CFLAGS:append = "-Werror=implicit -Werror=incompatible-pointer-types "

# GCC only.
SECURITY_CFLAGS:append = "-Wtrampolines"
