Создал Lesson2 и в нем модуль ActivityLifecycle. Переопределил основные методы. После этого добавил EditText на разметку.
![image](https://github.com/user-attachments/assets/c6058bfc-f426-46c8-b4c6-0f7ef48aec35)

В логах видно, как вызываются все эти методы в зависимости от действий с активновстью. После возврата в приложение метод onCreate не вызывается и значение editText не меняется. А вот если выйти из приложения через кнопку "назад", то editText обнулится.

Далее был реализован модуль MultiActivity. В первой активности сделал editText и кнопку "отправить". После нажатия на эту кнопку введенный текст переносится на textView второй активности.
![image](https://github.com/user-attachments/assets/65ac6b1e-4649-427d-a3de-c4d59b59f4f3)
![image](https://github.com/user-attachments/assets/99b706c3-163e-46c9-862b-b34842c228a0)
После нажатия на кнопку "отправить" вызываются методы onPause(), onStart() onResume(). Если нажать на кнопку "назад", то для второй активности в конце вызовется onDestroy()
![image](https://github.com/user-attachments/assets/940296a3-a139-459c-a6ad-4685e33be0b4)

В модуле IntentFilter были созданы две кнопки: для открытия сайта МИРЭА и для расшаривания своего ФИО. Для этого были использован метод Uri.parse() и класс Intent. 
![image](https://github.com/user-attachments/assets/97c8bd64-1dbb-4310-91a9-6051d4368aa8)
![image](https://github.com/user-attachments/assets/cb28479b-c716-438c-95c2-5e3527fcd07a)
![image](https://github.com/user-attachments/assets/36b547b2-1185-48e0-a23f-f2417a047ee9)

Первый модуль с уведомлениями - ToastApp. В методе onShowToastClick прописал toast-уведомление с моим номером и группой, а также кол-вом символов.
![image](https://github.com/user-attachments/assets/8ee863b5-50c6-43a9-9632-f1789f63c416)








