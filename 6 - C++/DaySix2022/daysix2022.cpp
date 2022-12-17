#include <fstream>
#include <iostream>

using namespace std;

int main() {
  string line;
  ifstream input("input");
  if (input.is_open()) {
    getline(input, line);
    input.close();
  } else {
    cout << "Unable to open file";
  }

  string letters;
  int marker_index;
  for (int i = 0; i < line.length(); i++) {
    char letter = line[i];
    if (letters.find(letter) != string::npos) {
      letters.erase(0, letters.find(letter) + 1);
    }
    letters += letter;
    if (letters.length() == 14) {
      marker_index = i;
      break;
    }
  }
  cout << marker_index + 1;
  return 0;
}