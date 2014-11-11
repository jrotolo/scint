VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "ubuntu/trusty32"

  config.ssh.username = "vagrant"
  config.ssh.private_key_path = "C:\\Users\\Jarrod\\.vagrant.d\\private_key"

  config.vm.provision :shell, path: 'bootstrap.sh', keep_color: true
  config.vbguest.auto_update = true

  # Virtualbox GUI for debug
  #config.vm.provider "virtualbox" do |v|
  #  v.gui = true
  #end

  

end
