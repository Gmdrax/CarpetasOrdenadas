import cv2
import mediapipe as mp
import pyautogui
import numpy as np

# Inicializa MediaPipe Hands
mp_hands = mp.solutions.hands
hands = mp_hands.Hands()
mp_draw = mp.solutions.drawing_utils

# Inicializa la cámara
cap = cv2.VideoCapture(0)

# Inicializa el suavizado del movimiento del cursor
last_n_positions = np.array([[0, 0]] * 5)

while True:
    # Lee el frame actual
    ret, frame = cap.read()

    # Convierte el frame a RGB (MediaPipe utiliza imágenes RGB)
    rgb_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)

    # Procesa el frame con MediaPipe Hands
    results = hands.process(rgb_frame)

    # Si se detectan manos
    if results.multi_hand_landmarks:
        for hand_landmarks in results.multi_hand_landmarks:
            # Obtiene las coordenadas del dedo índice
            x = hand_landmarks.landmark[mp_hands.HandLandmark.INDEX_FINGER_TIP].x
            y = hand_landmarks.landmark[mp_hands.HandLandmark.INDEX_FINGER_TIP].y

            # Convierte las coordenadas a pixeles
            screen_width, screen_height = pyautogui.size()
            x_pixel = int(x * screen_width)
            y_pixel = int(y * screen_height)

            # Añade la nueva posición al array de posiciones
            last_n_positions = np.roll(last_n_positions, -1, axis=0)
            last_n_positions[-1] = [x_pixel, y_pixel]

            # Calcula la posición media
            mean_position = last_n_positions.mean(axis=0).astype(int)

            # Mueve el ratón a la posición media
            pyautogui.moveTo(*mean_position)

    # Muestra el frame
    cv2.imshow('Frame', frame)

    # Rompe el bucle si se presiona 'q'
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Libera la cámara y destruye todas las ventanas
cap.release()
cv2.destroyAllWindows()



