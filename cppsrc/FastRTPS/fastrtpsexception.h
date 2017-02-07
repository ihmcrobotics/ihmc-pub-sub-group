#ifndef FASTRTPSEXCEPTION_H
#define FASTRTPSEXCEPTION_H
#include <exception>
#include <string>

class FastRTPSException : std::exception
{
public:
    FastRTPSException(std::string e) : error(e) {}


    const char * what() const throw()
    {
        return error.c_str();
    }
private:
    std::string error;
};

#endif // FASTRTPSEXCEPTION_H
