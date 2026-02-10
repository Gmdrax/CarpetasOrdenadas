import cv2
import mediapipe as mp
import pyautogui
import numpy as np

# Inicializa MediaPipe Hands
mp_hands = mp.solutions.hands
hands = mp_hands.Hands(max_num_hands=1, min_detection_confidence=0.7)
mp_draw = mp.solutions.drawing_utils

# Inicializa la cámara
cap = cv2.VideoCapture(0)

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
            # Dibuja las marcas de la mano en el frame
            mp_draw.draw_landmarks(frame, hand_landmarks, mp_hands.HAND_CONNECTIONS)

            # Obtiene las coordenadas de la punta del pulgar y del índice
            thumb_tip = np.array([hand_landmarks.landmark[mp_hands.HandLandmark.THUMB_TIP].x, hand_landmarks.landmark[mp_hands.HandLandmark.THUMB_TIP].y])
            index_finger_tip = np.array([hand_landmarks.landmark[mp_hands.HandLandmark.INDEX_FINGER_TIP].x, hand_landmarks.landmark[mp_hands.HandLandmark.INDEX_FINGER_TIP].y])

            # Calcula la distancia entre la punta del pulgar y la del índice
            distance = np.linalg.norm(thumb_tip - index_finger_tip)

            # Si la distancia es pequeña, asume que la mano está cerrada y minimiza todas las ventanas
            if distance < 0.1:
                pyautogui.hotkey('win', 'd')

    # Muestra el frame
    cv2.imshow('Frame', frame)

    # Rompe el bucle si se presiona 'q'
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Libera la cámara y destruye todas las ventanas
cap.release()
cv2.destroyAllWindows()
