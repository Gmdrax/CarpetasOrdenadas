import cv2
import mediapipe as mp

# Inicializa MediaPipe Hands
mp_hands = mp.solutions.hands
hands = mp_hands.Hands()
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

    # Dibuja los resultados
    if results.multi_hand_landmarks:
        for hand_landmarks in results.multi_hand_landmarks:
            mp_draw.draw_landmarks(frame, hand_landmarks, mp_hands.HAND_CONNECTIONS)

    # Muestra el frame
    cv2.imshow('Frame', frame)

    # Rompe el bucle si se presiona 'q'
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Libera la cámara y destruye todas las ventanas
cap.release()
cv2.destroyAllWindows()
