# Endava
eventsdava

Para WSL2 con Ubuntu

----------Docker----------
1) Remove residue
- $ sudo apt remove docker docker-engine docker.io containerd runc
2) Install dependencies
- $ sudo apt install --no-install-recommends apt-transport-https ca-certificates curl gnupg2
3) set some OS-specific variables:
- $ . /etc/os-release
4) make sure that apt will trust the repo:
- $ curl -fsSL https://download.docker.com/linux/${ID}/gpg | sudo tee /etc/apt/trusted.gpg.d/docker.asc
5) Then add and update the repo information so that apt will use it in the future:
- $ echo "deb [arch=amd64] https://download.docker.com/linux/${ID} ${VERSION_CODENAME} stable" | sudo tee /etc/apt/sources.list.d/docker.list
- $ sudo apt update
6) Install Docker
- $ sudo apt install docker-ce docker-ce-cli containerd.io
7) Launch dockerd
- $ sudo dockerd

----------Maven-----------
1) instalar JDK:
- $ sudo apt update
- $ sudo apt install openjdk-11-jdk
Verificar que esté instalado:
- $ java -version

2) Set Up Environment Variables
♦ Use the vim text editor to create and open the maven.sh script file in the /etc/profile.d/ directory:
- $ sudo vim /etc/profile.d/maven.sh

♦ Add the following lines to the maven.sh file:
export JAVA_HOME=/usr/lib/jvm/default-java
export M2_HOME=/opt/maven
export MAVEN_HOME=/opt/maven
export PATH=${M2_HOME}/bin:${PATH}
