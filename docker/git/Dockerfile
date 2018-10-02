FROM alpine:3.8

# Add ssh config for TFS
COPY .ssh/ /root/.ssh/

# Install git and ssh-keygen
# Create git folders
# Change .ssh permissions sinon git se plaint
RUN apk add --no-cache git=2.18.0-r0 openssh && \
    mkdir /git && \
    chmod -R 644 /root/.ssh && chmod 600 /root/.ssh/id_rsa

WORKDIR /git

ENTRYPOINT ["git"]

CMD ["--help"]
