inherit extrausers

IMAGE_INSTALL:append = " sudo"

# Disable root login
EXTRA_USERS_PARAMS:append = "usermod -L -e 1 root; "

# Create with 'printf "%q" $(mkpasswd -m sha512crypt <password>)'
PASSWD = "\$6\$xP4/w3BrfQnPAGEj\$2dhH4prV2hjSX49JCVXfm7Ttjepqegvr3TRT8OI0ju9cys0NRzD4tjHy4GaaQbBKaFC7aDDbfaH1Cv8YbOr4Z0"

EXTRA_USERS_PARAMS:append = "\
    useradd -p '${PASSWD}' developer; \
    usermod -a -G sudo developer; \
    "
