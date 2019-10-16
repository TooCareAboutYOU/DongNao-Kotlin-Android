#include <jni.h>
#include <string>

extern "C" {

JNIEXPORT jstring JNICALL
Java_com_dongnao_kotlin_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

JNIEXPORT jint JNICALL
Java_com_dongnao_kotlin_Kotlin2JavaActivity_java2Jni(JNIEnv *env,
                                                     jint x, jint y,
                                                     jobject /* this */) {


}

}