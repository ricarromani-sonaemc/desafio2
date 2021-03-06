import pipeline.Families
import pipeline.Family
import pipeline.Member


def call(body) {

    //def branch = env.BRANCH_NAME 
    def yamlObj
    def logs

    pipeline {
        agent any
        stages {
            
            stage('init') {
                steps {          
                    script {
                        logs = load "src/log/logs.groovy"

                        git branch: "yaml", credentialsId: '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', url: "https://github.com/ricarromani-sonaemc/desafio2.git"
                        
                        //sh "ls ${WORKSPACE}"
                        yamlObj = readYaml file: "${WORKSPACE}/yaml-families/family.yaml"
                        echo "${yamlObj}" 

                         
                               
                    }   
                }
            }
            
            stage('convert yaml to object') {
                steps {
                    script {

                        def flag;

                        Families families = new Families()                        
                        
                        echo "numero de familias = ${yamlObj.families.size()}"
                        for (int i = 0; i < yamlObj.families.size(); i++) {

                            Family family = new Family()
                            families.family.add(family)

                            echo "A familia ${i} é constituida por ${yamlObj.families[i].family[0].members.size()} membros."
                            //for (Families f : yamlObj.families)
                            for(int f = 0; f < yamlObj.families[i].family[0].members.size(); f++) {
                                //echo "${yamlObj.families[i].family[0].members[f]}"
                                Member member = new Member()
                                member.firstName = yamlObj.families[i].family[0].members[f].firstName
                                member.lastName = yamlObj.families[i].family[0].members[f].lastName
                                member.job = yamlObj.families[i].family[0].members[f].job
                                member.age = yamlObj.families[i].family[0].members[f].age
                                member.parent = yamlObj.families[i].family[0].members[f].parent
                                families.family.members.add(member)


                                if((member.parent == "Pai") && ((member.firstName == "") || (member.firstName == null) || (member.lastName == "") || (member.lastName == null)
                                || (member.job == "") || (member.job == null) || (member.age <= 0) || (member.age == null))){
                                    flag = 1
                                } 
                                else if((member.parent == "Mae") && ((member.firstName == "") || (member.firstName == null) || (member.lastName == "") || (member.lastName == null)
                                || (member.job == "") || (member.job == null) || (member.age <= 0) || (member.age == null))){
                                    flag = 1
                                }
                                if ((member.parent == "Filho") && (flag == 1)) {
                                    flag = 0 
                                    echo "O filho tb deu erro"
                                    break
                                }

                                if ((member.firstName == "") || (member.firstName == null)) {
                                    logs.log_error("O primeiro nome é invalido da familia ${i}")
                                }
                                else if ((member.lastName == "") || (member.lastName == null)) {
                                    logs.log_error("O último nome é invalido da familia ${i}")
                                } 
                                else if ((member.job == "") || (member.job == null)) {
                                    logs.log_error("O trabalho é invalido da familia ${i}")
                                } 
                                else if ((member.age <= 0) || (member.age == null)) {
                                    logs.log_error("A idade é invalido da familia ${i}")
                                }
                                else {  
                                    //"Olá, o meu nome é X, tenho Z anos e vim da cidade Y. A minha profissão é K."                       
                                    logs.log_succeed("Olá, o meu nome é ${member.firstName} ${member.lastName} e tenho ${member.age} anos. A minha profissão é ${member.job}.")
                                }
                            }
                        }      
                    }
                }         
            }
            //stage criação das pasta e dos ficheiros
            stage('') {
                steps {
                    script {
                        //sh "mkdir ${WORKSPACE}/families"
                        writeFile file: "${WORKSPACE}/families/familia.txt", text: "This file is useful, need to archive it."

                        
                    }
                }
            }

            //stage logs
        }
    }
}